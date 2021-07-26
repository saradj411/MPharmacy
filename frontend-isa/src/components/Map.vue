<template>
<div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
    
  <div id="map">
      <yandex-map
    :center="[55.681576, 37.488467]"
    :zoom="10"
    :dragable="false"
    :scrollZoom="false"
    @created="mapCreated">
    
        <region-select
          button-text="Please select ..."
          :region="[[55.761104221485205, 37.589244608215324],[55.753360214866454, 37.519893411926276], [55.74329069752624, 37.57207847052001]]"
          @changed="regionChanged">
        </region-select>
</yandex-map>

<!--
import YandexMap from 'vue-yandex-map'
Vue.use(YandexMap, {
    version: '2.1',
    lang: 'ru_RU',
    apiKey: '',
});

export default {
      name: 'app',
      data () {
        return {
          map: null,
          map_data: [],
          mapObjectManager: null
        }
      },
      methods: {
        yamapReady: function () {

        },
        mapCreated: function ($map) {
          console.info('mapCreated, $map=', $map)

          this.map = $map
          this.mapObjectManager = new ymaps.ObjectManager({
            clusterize: false,
            gridSize: 60,
            clusterMinClusterSize: 5,
            clusterHasBalloon: true, // Опции кластеров задаются с префиксом cluster.
            geoObjectOpenBalloonOnClick: false // Опции геообъектов задаются с префиксом geoObject
          })

          this.map.behaviors.disable('drag')

          // set ObjectManager events
          this.map.events.add(['click'], function(){
            this.mapObjectManager.objects.balloon.close()
          })

          // add points on map
          // ...
        },
        mapDestroy: function($map) {
          console.info('mapDestroy')
        },
        regionChanged: function ($coordinates, $polygon) {

          console.info('regionChanged, coord=', $coordinates)

          let visibleID = [];

          if (typeof $polygon === 'undefined') {
            $polygon = null;
          }

          this.map.behaviors.disable('drag');

          // check points in region
          this.mapObjectManager.setFilter(function (object) {

            let in_poligon = $polygon === null ? false : $polygon.geometry.contains(object.geometry.coordinates);
            let visible = $polygon === null ? true :  in_poligon;

            if($polygon !== null && in_poligon) {
              visibleID.push(object.id)
            }

            return visible
          })

          console.log('map, selected point ID', visibleID)
        }
      }
    }-Ovo je za mapu -->

    <div id="mapContainer" style="height:700px;width:100%" ref="hereMap"></div>
  </div>
</div>
</template>

<script>
export default {
  name: "HereMap",
  props: {
    center: Object
    
  },
  data() {
    return {
      platform: null,
      apikey: "sDjdDihEOSrkRErqE-olId_Mt6uMwB35dpNuycSBCO4",
      address : "",
      addressInfo : "",
      lat :0,
      long : 0,
      id : this.$route.params.id,
      
    };
  },
  async mounted() {
    
    const platform = new window.H.service.Platform({
      apikey: this.apikey,
    });
    this.platform = platform;
        this.axios.get('/pharmacy/mapp/'+this.id)
        .then(response => {
                this.addressInfo = response.data;
                this.address = this.addressInfo.country+" "+this.addressInfo.town+" "+this.addressInfo.street+" "+this.addressInfo.number;
                this.axios.get('https://geocoder.api.here.com/6.2/geocode.json?app_id=aJx1PxrXFwpMDT0M30rJ&app_code=am23BxvdgXkXf2c15NUZgw&searchtext='+this.address)
         .then(response => {
             console.log(response.data);
                    this.lat =  response.data.Response.View[0].Result[0].Location.DisplayPosition.Latitude;
                    this.long = response.data.Response.View[0].Result[0].Location.DisplayPosition.Longitude;
                    this.initializeHereMap();
                })
         }).catch(res => {
                alert("greska aaaa");
                console.log(res);
        });
       
                  
    
       
    
  },
  methods: {
    initializeHereMap() { 
      const mapContainer = this.$refs.hereMap;
      const H = window.H;
     
      var maptypes = this.platform.createDefaultLayers();
      
      var map = new H.Map(mapContainer, maptypes.vector.normal.map, {
        zoom: 15,
        center: { lat: this.lat, lng: this.long }
        
      });
      addEventListener("resize", () => map.getViewPort().resize());
      
      new H.mapevents.Behavior(new H.mapevents.MapEvents(map));
    let marker = new H.map.Marker({ lat: this.lat, lng: this.long })
    map.addObject(marker);
     
      H.ui.UI.createDefault(map, maptypes);
     
    }
  }
};
</script>

<style scoped>
#map {
  width: 70vw;
  min-width: 370px;
  text-align: center;
  margin: 8% auto;
  background-color: rgb(204, 204, 204);
}
</style>