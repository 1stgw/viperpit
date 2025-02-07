const sass = require("sass");

module.exports = {
  lintOnSave: process.env.NODE_ENV !== "production",
  runtimeCompiler: true,
  productionSourceMap: true,
  transpileDependencies: ["vuetify"],
  css: {
    loaderOptions: {
      sass: {
        sassOptions: {
          logger: sass.Logger.silent,
          silenceDeprecations: ["slash-div", "import"],
          quietDeps: true
        }
      }
    }
  },
  devServer: {
    proxy: {
      "^/services": {
        target: "http://[::1]:8090",
        ws: true,
        changeOrigin: true
      }
    },
    compress: false
  }
};
