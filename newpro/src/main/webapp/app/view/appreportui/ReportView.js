Ext.define('Newpro.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Newpro.view.appreportui.ReportViewController',
	            'Newpro.view.appreportui.datagrid.DataGridPanel',
	            'Newpro.view.appreportui.datagrid.DataGridView',
	            'Newpro.view.appreportui.querycriteria.QueryCriteriaView',
	            'Newpro.view.appreportui.chart.ChartView',
	            'Newpro.view.appreportui.datapoint.DataPointView',
	            'Newpro.view.googlemaps.map.MapPanel',
	            'Newpro.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
