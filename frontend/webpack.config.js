const path = require('path');

module.exports = {
  entry: {
    indexApp: './src/index/indexApp.js'
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'public/js'),
  },

  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ['style-loader', 'css-loader'],
      },
      {
        test: /\.m?js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: "babel-loader"
        }
      }
    ]
  }

};
