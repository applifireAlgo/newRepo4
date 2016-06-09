Ext.define('Testpro2.view.desktop.MainViewport', {
		extend:'Ext.container.Viewport',
		bodyPadding : 5,
		closable : false,
		xtype : 'mainViewport',
		id:'mainViewport',
		autoDestroy : true,
		requires : ['Testpro2.view.desktop.design.drawer.main.MainPanel'],
		layout:'fit',
		title:'Viewport',
		items:[{
			xtype:'mainPanel'
		}]
});