module.exports = {
    devServer: {
        port: 3003
    }
}
/*
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'http://localhost:8083/api',
                ws: true,
                changeOrigin: true
            }
        }
    }
}
*/