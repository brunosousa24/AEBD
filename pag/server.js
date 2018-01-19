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
	var mem = require('../Json/memory_storage.json')
	res.render('memstorage', {items:mem.items});
  });


app.get('/app/roles',(req,res) => {
	var roles = require('../Json/roles.json')
	res.render('roles', {items:roles.items});
  });


app.get('/app/users',(req,res) => {
	var users = require('../Json/users.json')
	res.render('users', {items:users.items});
  });

app.get('/app/sql',(req,res) => {
	var sqlc = require('../Json/sql.json')
	res.render('sql', {items:sqlc.items});
  });


app.get('/app/datafiles',(req,res) => {
	var sqlc = require('../Json/datafiles.json')
	res.render('dataf', {items:sqlc.items});
  });

app.listen(5555 , () => {
	console.log("Servidor iniciado!");
})



