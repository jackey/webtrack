var bones = require("bones"),
	mysqllib = require("mysql");

// Load mysql instance
global.mysql = mysqllib.createPool({
	host: "localhost",
	user: "root",
	password: "admin",
	database: "dbc_ateliercocktail",
	charset: "UTF8_GENERAL_CI",
	bigNumberStrings: true
});

bones.load(__dirname);

if (!module.parent) {
	bones.start();
}

