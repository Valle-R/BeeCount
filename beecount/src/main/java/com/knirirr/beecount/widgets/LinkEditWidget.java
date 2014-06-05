package com.knirirr.beecount.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.knirirr.beecount.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by milo on 04/06/2014.
 */
public class LinkEditWidget extends LinearLayout
{
  Spinner masterSpinner;
  Spinner slaveSpinner;
  Spinner choiceSpinner;
  EditText linkIncrement;
  ImageButton deleteLink;

  public long linkId;


  public LinkEditWidget(Context context, AttributeSet attrs)
  {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.widget_link_edit, this, true);
    masterSpinner = (Spinner) findViewById(R.id.masterSpinner);
    slaveSpinner = (Spinner) findViewById(R.id.slaveSpinner);
    choiceSpinner = (Spinner) findViewById(R.id.choiceSpinner);
    linkIncrement = (EditText) findViewById(R.id.linkIncrement);
    deleteLink = (ImageButton) findViewById(R.id.deleteLink);
    deleteLink.setTag(Long.valueOf(0));

    /*
     * Some sort of static array would be better here, and should be added when a cunning idea for how
     * to do it springs to mind.
     */
    ArrayList<String> choices = new ArrayList<String>();
    choices.add(getResources().getString(R.string.incr_up));
    choices.add(getResources().getString(R.string.incr_down));
    choices.add(getResources().getString(R.string.incr_reset));

    setSpinnerAdapter("choice",choices);

  }

  public void setLinkId(long id)
  {
    linkId = id;
    deleteLink.setTag(id);
  }

  public void setSpinnerAdapter(String spinner, ArrayList<String> array)
  {
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner, array)
    {
      public View getView(int position, View convertView, ViewGroup parent)
      {
        View v = super.getView(position, convertView, parent);
        ((TextView) v).setTextColor(Color.WHITE);
        return v;
      }
      public View getDropDownView(int position,  View convertView,  ViewGroup parent)
      {
        View v = super.getDropDownView(position, convertView, parent);
        ((TextView) v).setTextColor(Color.WHITE);
        return v;
      }
    };
    if (spinner.equals("master"))
    {
      masterSpinner.setAdapter(adapter);
    }
    else if (spinner.equals("slave"))
    {
      slaveSpinner.setAdapter(adapter);
    }
    else if (spinner.equals("choice"))
    {
      choiceSpinner.setAdapter(adapter);
    }

  }

}