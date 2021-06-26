package io.kebblar.petstore.api.service;

public class ChartWrapper {
    private ChartData chart;

    public ChartWrapper() {
    }
    public ChartWrapper(ChartData chart) {
        this.chart = chart;
    }

    public ChartData getGraphData() {
        return chart;
    }

    public void setGraphData(ChartData chart) {
        this.chart = chart;
    }

    @Override
    public String toString() {
        return "Chart [graphData=" + chart + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chart == null) ? 0 : chart.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChartWrapper other = (ChartWrapper) obj;
        if (chart == null) {
            if (other.chart != null)
                return false;
        } else if (!chart.equals(other.chart))
            return false;
        return true;
    }
    
}
