/**
 * Copyright (C) 2010 Leon Blakey <lord.quackstar at gmail.com>
 *
 * Based on LoggingAppender from https://code.google.com/p/quackedcube/
 */
package com.github.lawena.util;

import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class LoggingAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

  private final JTextPane pane;
  private final SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");
  private boolean printStackTrace = false;

  public LoggingAppender(JTextPane pane, LoggerContext context) {
    this.pane = pane;
    setName("LoggingAppender");
    setContext(context);
    start();
  }

  public boolean isPrintStackTrace() {
    return printStackTrace;
  }

  public void setPrintStackTrace(boolean printStackTrace) {
    this.printStackTrace = printStackTrace;
  }

  @Override
  public void append(ILoggingEvent event) {
    SwingUtilities.invokeLater(new WriteOutput(event));
  }

  public class WriteOutput implements Runnable {

    private StyledDocument doc;
    private ILoggingEvent event;

    public WriteOutput(ILoggingEvent event) {
      this.doc = pane.getStyledDocument();
      this.event = event;

      if (doc.getStyle("Class") == null) {
        doc.addStyle("Normal", null);
        StyleConstants.setForeground(doc.addStyle("Class", null), Color.blue);
        StyleConstants.setForeground(doc.addStyle("Error", null), Color.red);
        StyleConstants.setItalic(doc.addStyle("Level", null), true);
      }
    }

    @Override
    public void run() {
      try {
        String message = event.getFormattedMessage().trim();
        if (name.trim().equals(""))
          return;
        Style msgStyle = null;
        if (event.getLevel().isGreaterOrEqual(Level.WARN)) {
          msgStyle = doc.getStyle("Error");
        } else {
          msgStyle = doc.getStyle("Normal");
        }
        doc.insertString(doc.getLength(), "\n", doc.getStyle("Normal"));
        int prevLength = doc.getLength();
        doc.insertString(doc.getLength(), "[" + dateFormatter.format(event.getTimeStamp()) + "] ",
            doc.getStyle("Normal"));
        doc.insertString(doc.getLength(), event.getLevel().toString() + "  ", doc.getStyle("Level"));
        // doc.insertString(doc.getLength(), event.getLoggerName() + " ", doc.getStyle("Class"));
        doc.insertString(doc.getLength(), formatMsg(event, message), msgStyle);
        pane.setCaretPosition(prevLength);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public String formatMsg(ILoggingEvent event, String message) {
      ThrowableProxy throwArr = (ThrowableProxy) event.getThrowableProxy();
      if (throwArr == null)
        return message;
      StringBuilder builder = new StringBuilder(message);
      Throwable ex = throwArr.getThrowable();
      if (printStackTrace) {
        builder.append("\n");
        StringWriter writer = new StringWriter();
        ex.printStackTrace(new PrintWriter(writer));
        builder.append(writer);
      } else {
        String exString = ex.toString();
        if (exString != null) {
          builder.append("\n");
          builder.append("Caused by " + exString);
        }
      }
      return builder.toString();
    }
  }
}