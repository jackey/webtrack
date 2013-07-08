var deferred = require("deferred");

router = Backbone.Router.extend({
	routes: {
		"/": "home",
	},
	home: function () {
		
	},
	send: function (view) {
		// Nothing to do on client side.
		this.res.send(view.render());
	}
});