package ru.galkov.pointController.visualiser.frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
public class Visualiser extends JFrame implements Runnable {


    private ApplicationContext context;
    private VisualiserPointHolder pointHolder;
    private final int w = 1280;
    private final int h = 720;
    private final BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    private final BufferedImage pimg = new BufferedImage(w / 8, h / 8, BufferedImage.TYPE_INT_RGB);
    private final NN_Algorithm nn;
    public List<VisualiserPoint> points = new ArrayList<>();
    private final Color POINT_TYPE_LCM = Color.GREEN;
    private final Color POINT_TYPE_RCM = Color.BLUE;

    public Visualiser() {
        UnaryOperator<Double> sigmoid = x -> 1 / (1 + Math.exp(-x));
        UnaryOperator<Double> dsigmoid = y -> y * (1 - y);
        nn = new NN_Algorithm(0.01, sigmoid, dsigmoid, 2, 5, 5, 2);

        this.setSize(w, h);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(50, 50);
        this.add(new JLabel(new ImageIcon(img)));

    }

    public Visualiser setContext(ApplicationContext context) {
        this.context = context;
        return  this;
    }

    public Visualiser setPointHolder(VisualiserPointHolder pointHolder) {
        this.pointHolder = pointHolder;
        if (pointHolder.isNotEmpty())
            points = new ArrayList<>(pointHolder.getPoints());
        return  this;
    }

    @Override
    public void run() {
        while (true) {
            //TODO тут будут новые положения точек и их количество. пределать сочетание процессов перемещения точек-дронов и расчёта линии раздела.
            if (pointHolder.isModified()) {
                this.repaint();
                pointHolder.setModified(false);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (points.size() > 0) {
            for (int k = 0; k < points.size() * 100; k++) {
                VisualiserPoint p = points.get((int) (Math.random() * points.size()));
                double nx = (double) p.getX() / w - 0.5;
                double ny = (double) p.getY() / h - 0.5;
                double[] targets = new double[2];

                if (POINT_TYPE_LCM.equals(p.getType()))
                    targets[0] = 1;
                else
                    targets[1] = 1;

                nn.feedForward(new double[]{nx, ny});
                nn.backpropagation(targets);
            }
        }

        for (int i = 0; i < w / 8; i++)
            for (int j = 0; j < h / 8; j++)
                pimg.setRGB(i, j, getRGB(i, j));

        Graphics ig = img.getGraphics();
        ig.drawImage(pimg, 0, 0, w, h, this);
        drawPoints(ig);
        g.drawImage(img, 8, 30, w, h, this);
    }

    private void drawPoints(Graphics ig) {
        for (VisualiserPoint p : points) {
            ig.setColor(Color.WHITE);
            ig.fillOval(p.getX() - 3, p.getY() - 3, 26, 26);
            ig.setColor(p.getType());
            ig.fillOval(p.getX(), p.getY(), 20, 20);
        }
    }

    private int getRGB(int i, int j) {
        double[] outputs = nn.feedForward(new double[]{(double) i / w * 8 - 0.5, (double) j / h * 8 - 0.5});
        double green = 0.3 + Math.max(0, Math.min(1, outputs[0] - outputs[1] + 0.5)) * 0.5;
        double blue = 0.5 + (1 - green) * 0.5;

        return (100 << 16) | ((int) (green * 255) << 8) | (int) (blue * 255);
    }

}