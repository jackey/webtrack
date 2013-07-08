view = Backbone.View.extend({
	initialize: function (options) {
		this.model = options.model || (new Backbone.Model);
	},
	render: function () {
		return JSON.stringify(this.model.toJSON());
	},
});