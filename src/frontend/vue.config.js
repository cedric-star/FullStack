const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // https://cli.vuejs.org/config/#devserver-proxy
  devServer: {
    port: 8081,
    proxy: {
      '/app': {
        //target: 'http://localhost:8080',
        target: 'http://192.168.178.79:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
})
