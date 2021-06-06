<template>
  <div >
    <div >
      <FullCalendar :options="calendarOptions">
      </FullCalendar>
    </div>
    <div>
      <b-modal ref="my-modal"  hide-footer title= "INFORMACIJE">
        <b-row text-align-center>
          <b-col> </b-col>
          <b-col>
            <h4
              text-align-center
              v-bind:style="{ align: 'center', justify: 'center' }"
            >
              {{ this.pharmacyName }}
            </h4>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form inline>
              <b-form-input
                v-if="isAvailable"
                v-model="name"
                id="inline-form-input-name"
                placeholder="Nema pacijenta"
              ></b-form-input>
            </b-form>
          </b-col>
          <b-col>
            <b-form inline>
              <b-form-input
                v-if="isAvailable"
                v-model="surname"
                id="inline-form-input-name"
                placeholder="Nema pacijenta"
              ></b-form-input>
            </b-form>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form inline>
              <b-form-input
                v-model="startDate"
                id="inline-form-input-name"
                placeholder="Jane Doe"
              ></b-form-input>
            </b-form>
          </b-col>
          <b-col>
            <b-form inline>
              <b-form-input
                v-model="endDate"
                id="inline-form-input-name"
                placeholder="Jane Doe"
              ></b-form-input>
            </b-form>
          </b-col>
          <b-col>
            <b-button
              variant="outline-info"
              block
              @click="hideModal"
              >Nazad</b-button
            >
          </b-col>

          
                 </b-row>
      </b-modal>
    </div>
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
export default {
  components: {
    FullCalendar, // make the <FullCalendar> tag available
  },
  data: function() {
    return {
      calendarOptions: {
        plugins: [
          dayGridPlugin,
          timeGridPlugin,
          interactionPlugin, // needed for dateClick
        ],
        headerToolbar: {
          left: "prev,next today",
          center: "title",
          right: "dayGridMonth,timeGridWeek,timeGridDay",
        },
        initialView: "dayGridMonth",
        editable: false,
        selectable: true,
        selectMirror: true,
        dayMaxEvents: true,
        weekends: true,
        select: this.handleDateSelect,
        eventClick: this.handleEventClick,
        eventsSet: this.handleEvents,
        events: this.examinations,
        /* you can update a remote database when these fire:
        eventAdd:
        eventChange:
        eventRemove:
        */
      },
      isAvailable: true,
      examinations: [],
      currentEvents: [],
      name: "",
      surname: "",
      pharmacyName: "",
      patientSurname:"",
      patientName:"",
      startDate: "",
      endDate: "",
      idPatient: "",
      idExamination: "",
      currentExamination: "",
      isCurrentExamination: false,
      definedExaminations: [],
    };
  },
  created() {
    // GET request for examination information
    this.axios.get("examination/callendar/"+501)
      .then((response) => {
        this.definedExaminations = response.data;//svi pregledi
        let examinationsForCalendar = [];
        
        for (let i in response.data) {
          let ex = response.data[i];//uzmje jedan pregled
          let date=ex.date;
          let startDate =ex.start;
          let endDate =ex.end;
          console.log("ajdee "+date);

          let newEvent = {
            id: ex.idExamination,
            pharmacyName: ex.pharmacyName,
            date:ex.date,
            idPatient:ex.idPatient,
            start: startDate,
            end: endDate,
            patientName:ex.patientName,
            patientSurname:ex.patientSurname,
            backgroundColor: "#ff0000",
          };
          examinationsForCalendar.push(newEvent);
        }
        this.examinations = examinationsForCalendar;
        this.calendarOptions.events = examinationsForCalendar;
      })
      .catch((error) => {
        this.errorMessage = error.message;
        this.$notify({
          type: "success",
          title: "Success",
          text: this.message,
          closeOnClick: true,
        });
      });
  }, mounted() {

  },
  methods: {
    handleWeekendsToggle() {
      this.calendarOptions.weekends = !this.calendarOptions.weekends; // update a property
    },
    handleDateSelect(selectInfo) {
      //let title = prompt('Please enter a new title for your event')
      let calendarApi = selectInfo.view.calendar;
      calendarApi.unselect(); // clear date selection
      // if (title) {
      //   calendarApi.addEvent({
      //     id: createEventId(),
      //     title,
      //     start: selectInfo.startStr,
      //     end: selectInfo.endStr,
      //     allDay: selectInfo.allDay
      //   })
      // }
    },
    handleEventClick(clickInfo) {
      this.$refs["my-modal"].show();
      //console.log(clickInfo);
      let exam = this.definedExaminations.filter((obj) => {
        return obj.id == clickInfo.event.id;
      });
      this.pharmacyName = exam[0].pharmacyName;
      this.name = exam[0].patientName;
      this.surname = exam[0].patientSurname;
      this.startDate = exam[0].start;
      this.endDate = exam[0].end;
      this.startDate = this.startDate.toLocaleString();
      console.log("dnshfchd"+this.startDate);
      //this.endDate = this.endDate.toLocaleString();
      this.idPatient = exam[0].idPatient;
      this.idExamination = exam[0].id;
      if (this.name === "") {
        this.isAvailable = false;
      } else {
        this.isAvailable = true;
      }
    },
    hideModal() {
      this.$refs["my-modal"].hide();
    },
    
    handleEvents(events) {
      this.currentEvents = events;
    },
    
   
  },
};
</script>