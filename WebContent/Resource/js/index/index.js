var MainView = Backbone.View.extend({
	render: function(){
		$(this.el).html($.tpl['information']());
	}
});
var AppRouter = Backbone.Router.extend({
	routes:{
		"": "main",
	},
	main: function(){
		var mainView = new MainView({
			el: $("article.article")
		});
		mainView.render()
	}
});

(function($){
	$(document).ready(function(){
		app = new AppRouter()	
		Backbone.history.start()
	})
})(jQuery);