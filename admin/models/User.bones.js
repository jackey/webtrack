model = Backbone.Model.extend({
	defaults: {
		name: "",
		pass: "",
		mail: "",
	},
	idAttribute: "uid",
	sync: function (method, model, options) {
		if (method != "read") throw new Exception("Only support read feature for user");
		
		mysql.getConnection(function (err, conn) {
			if (err) {
				(options["error"] || function () {console.log(error)})();
			}
			else {
				conn.query("SELECT * FROM users where uid=1", function (err, rows) {
					if (err) {
						(options["error"] || function () {console.log(error)})();
					}
					else {
						(options["success"] || function () {})(_.first(rows));
					}
					conn.end();
				});
			}
		});
	}
});