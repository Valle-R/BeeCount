package com.knirirr.beecount.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.knirirr.beecount.R;

/**
 * Created by milo on 27/05/2014.
 */
public class OptionsWidget extends LinearLayout
{
  public int count_parameter_value;
  private TextView instructions;
  private TextView number;

  public OptionsWidget(Context context, AttributeSet attrs)
  {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.options_widget, this, true);
    instructions = (TextView) findViewById(R.id.help_text);
    number = (TextView) findViewById(R.id.count_parameter_edit);
  }

  public void setInstructions(String i)
  {
    instructions.setText(i);
  }

  public void setParameterValue(int i)
  {
    count_parameter_value = i;
    number.setText(String.valueOf(i));
  }

}