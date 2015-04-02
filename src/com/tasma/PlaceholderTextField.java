package com.tasma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PlaceholderTextField extends JTextField {

    private String placeholder;
    private Color placeholderColor = getDisabledTextColor();

    public PlaceholderTextField() {
    }

    public PlaceholderTextField(final String text) {
        super(text);
    }

    public PlaceholderTextField(final int columns) {
        super(columns);
    }

    public PlaceholderTextField(final Document doc, final String text, final int columns)
    {
        super(doc, text, columns);
    }

    public PlaceholderTextField(final String text, final int columns) {
        super(text, columns);
    }

    public String getPlaceholder() {
        return placeholder;
    }
    
    public Color getPlaceholderColor() {
    	return placeholderColor;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(placeholderColor);
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
            .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
    
    public void setPlaceholderColor(Color color) {
    	this.placeholderColor = color;
    }

}