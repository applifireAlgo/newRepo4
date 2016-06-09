Ext.define('Newpro.view.databrowsercalendar.DBCalendar', {
	extend : 'Newpro.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Newpro.view.databrowsercalendar.DBCalendarController',
	             'Newpro.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
