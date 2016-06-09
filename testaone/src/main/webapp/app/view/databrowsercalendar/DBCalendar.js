Ext.define('Testaone.view.databrowsercalendar.DBCalendar', {
	extend : 'Testaone.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testaone.view.databrowsercalendar.DBCalendarController',
	             'Testaone.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
