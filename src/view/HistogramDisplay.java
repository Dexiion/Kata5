package view;


import model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{ 

    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        
        
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart =  ChartFactory.createBarChart("JFreeChart Histogram",
                                                        "email domins",
                                                        "nº emails",
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int others_count = 0;
        
        for (String key : histogram.keySet()) {
            if(histogram.get(key) > 1) {
                dataSet.addValue(histogram.get(key), "", key);
                    
            } else {
                others_count++;
            }
            dataSet.addValue(others_count, "", "others");
        }
        
        return dataSet;
    }
    
    public void execute() {
        this.setVisible(true);
    }
}
