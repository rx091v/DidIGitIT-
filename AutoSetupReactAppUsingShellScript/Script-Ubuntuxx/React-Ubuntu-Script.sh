#!/bin/bash
rm -r app
echo
echo -e "PROJECT NAME ? "
read name
mkdir $name
echo "$name CREATED !!"
mkdir app
cd app
mkdir components
cd components
touch Main.js
echo "var React = require('react');
var ReactDOM = require('react-dom');

var Main = React.createClass({
render: function(){ 
      return( 
        <div> 
          Hello World 
        </div> 
      ) 
    } 
 }); 

ReactDOM.render(<Main/>, document.getElementById('app'))"> Main.js



cd ../..
cd $name
touch index.html

echo "<!DOCTYPE html>
<html lang=\"en\">
<head>
  <meta charset=\"UTF-8\">
  <title>React Github Notetaker</title>
  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">
</head>
<body>
  <div id=\"app\"></div>
  <script src=\"bundle.js\"></script>
</body>
</html>" > index.html

cd ..
touch webpack.config.js

echo "module.exports = {
  entry: \"./app/components/Main.js\",
  output: {
    filename: \"$name/bundle.js\"
  },
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel-loader',
        query: {
          presets: ['react', 'es2015']
        }
      }
    ]
  }
}"> webpack.config.js

echo "[INSTALLING NPM](1/5)"
npm init

echo "[INSTALLING REACT](2/5)"
npm install --save react@0.14.3

echo "[INSTALLING REACT DOM](3/5)"
npm install --save react-dom@0.14.3

echo "[INSTALLING BABEL](4/5)"
npm install --save babel-core@6.3.13 babel-loader@6.2.0 babel-preset-es2015@6.3.13 babel-preset-react@6.3.13

echo "[INSTALLING NODEJS LEGACY](5/5)"
npm install webpack -g

"[RUNNING WEBPACK]"
webpack -w
