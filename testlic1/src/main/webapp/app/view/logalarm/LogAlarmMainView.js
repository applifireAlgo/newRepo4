/**
 * 
 */
Ext.define('Testlic1.view.logalarm.LogAlarmMainView', {
	extend : 'Ext.form.Panel',
	xtype : 'logAlarmMainView',
	requires : [ 'Testlic1.view.logalarm.LogAlarmMainViewController',
			'Testlic1.view.logalarm.tree.LogAlarmTreePanel',
			'Testlic1.view.logalarm.mainscreen.LogAlarmMainViewTabPanel',
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
