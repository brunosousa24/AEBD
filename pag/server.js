/*
Iniciar servidor que trata de pedidos
*/
var express = require('express');
var app = express();
var cjson = require('cjson');


app.set('view engine', 'pug');

app.use(express.static(__dirname+'/javascripts'))

app.get('/', (req,res) => {
	res.render('index');
})

app.get('/app/cpu',(req,res) => {
	var cpu = require('../Json/cpu.json')
	res.render('cpu', {items:cpu.items});
  });


app.get('/app/memstorage',(req,res) => {
	var mem = require('../Json/memory_storage.json')
	res.render('memstorage', {items:mem.items});
	});



app.get('/app/memstorage/json',(req,res) => {
	var mem = cjson.load('../Json/memory_storage.json')
		res.json(mem)
		});

app.get('/app/roles',(req,res) => {
	var roles = require('../Json/roles.json')
	res.render('roles', {items:roles.items});
  });


app.get('/app/users',(req,res) => {
	var users = require('../Json/users.json')
	//console.log(users)
	res.render('users', {items:users.items});
  });

app.get('/app/sql',(req,res) => {
	var sqlc = require('./Json/sql.json')
	res.render('sql', {items:sqlc.items});
  });


app.get('/app/datafiles',(req,res) => {
	var s = require('../Json/datafiles.json')
	res.render('dataf', {items:s.items});
  });

app.get('/app/tablespaces',(req,res) => {
	var s = require('../Json/tablespaces.json')
	res.render('tablespaces', {items:s.items});
  });

app.get('/app/tablespaces/json',(req,res) => {
	var mem = cjson.load('./Json/tablespaces.json')
	res.json(mem)
	});

app.get('/app/sessions',(req,res) => {
	var s = require('../Json/sessions.json')
	res.render('sessions', {items:s.items});
  });


app.listen(5555 , () => {
	console.log("Servidor iniciado!");
})



