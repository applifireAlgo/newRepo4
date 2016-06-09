/**
 * 
 */
Ext.define('Testschedular.view.logalarm.LogAlarmMainView', {
	extend : 'Ext.form.Panel',
	xtype : 'logAlarmMainView',
	requires : [ 'Testschedular.view.logalarm.LogAlarmMainViewController',
			'Testschedular.view.logalarm.tree.LogAlarmTreePanel',
			'Testschedular.view.logalarm.mainscreen.LogAlarmMainViewTabPanel',
			'Ext.layout.container.Column','Ext.form.field.Hidden' ],

	controller : 'logAlarmMainViewController',

	layout : 'column',
	autoScroll : true,
	defaults : {
		margin : 10,
	},
	items : [ {
		columnWidth : '0.20',
		xtype : 'logAlarmTreePanel',
		itemId : 'logAlarmTreePanel',
	}, {
		columnWidth : '0.80',
		xtype :  'logAlarmMainViewTabPanel',
		itemId : 'logAlarmMainViewTabPanel'
	}],
	buttons : [ {
		text : 'Reset',
		itemId : 'clearButton',
		icon : 'images/entitybuilder/reset.png',
		handler : 'onClearButton',
	}, {
		text : 'Update',
		itemId : 'saveButton',
		icon : 'images/entitybuilder/save.png',
		formBind : true,
		handler : 'onSaveButton',
	} ]
});
