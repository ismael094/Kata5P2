/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Usuario
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Histogram;
import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Usuario
 */
public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram; 
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private JPanel createPanel() {
        ChartPanel chart = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chart;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", "Dominios Email", "Nº Emails",dataSet,PlotOrientation.VERTICAL,true,false,rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (String key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", key);
        }
        
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
    }
    
}