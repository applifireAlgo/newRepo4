Ext.define('Testschedular.view.databrowsercalendar.DBCalendar', {
	extend : 'Testschedular.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testschedular.view.databrowsercalendar.DBCalendarController',
	             'Testschedular.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
