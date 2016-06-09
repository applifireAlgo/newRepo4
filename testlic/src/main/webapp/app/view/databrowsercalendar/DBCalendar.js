Ext.define('Testlic.view.databrowsercalendar.DBCalendar', {
	extend : 'Testlic.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testlic.view.databrowsercalendar.DBCalendarController',
	             'Testlic.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
