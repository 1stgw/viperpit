module.exports = {
  lintOnSave: process.env.NODE_ENV !== "production",
  runtimeCompiler: true,
  productionSourceMap: true,
  transpileDependencies: ["vuetify"],
  css: {
    loaderOptions: {
      sass: {
        sassOptions: {
          quietDeps: true
        }
      }
    }
  }
};
