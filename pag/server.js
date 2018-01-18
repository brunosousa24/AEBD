/*
Iniciar servidor que trata de pedidos
*/
var express = require('express');
var app = express();
var db = require('oracledb');

app.set('view engine', 'pug');

app.use(express.static(__dirname+'/javascripts'))

app.get('/', (req,res) => {
	res.render('index');
})


app.get('/app/cpu',(req,res) => {

	res.render('cpu');
  });


app.get('/app/memstorage',(req,res) => {

	res.render('memstorage');
  });

app.get('/app/roles',(req,res) => {

	res.render('roles');
  });

app.listen(5555 , () => {
	console.log("Servidor iniciado!");
})


    /*connection.execute(
      "SELECT DBID FROM CPU",
      function(err, result)
      {
        if (err) {
          console.error(err.message);
          app.doRelease(connection);
          return;
        }

		res.render('cpu', res)
        app.doRelease(connection);
      });
	});
});


	
app.doRelease = function(connection) {
    connection.release(function(err) {
        if (err) {
            console.log("ERROR: Unable to RELEASE the connection: ", err);
        }
        return;
    });
};
*/


