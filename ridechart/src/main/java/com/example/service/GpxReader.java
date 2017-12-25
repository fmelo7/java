package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
public class GpxReader extends DefaultHandler {

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private List<Trackpoint> track = new ArrayList<Trackpoint>();
    private StringBuffer buf = new StringBuffer();
    private double lat;
    private double lon;
    private double ele;
    private Date time;

    public static Trackpoint[] readTrack(InputStream in) throws IOException {
	try {
	    SAXParserFactory factory = SAXParserFactory.newInstance();
	    factory.setValidating(true);
	    SAXParser parser = factory.newSAXParser();
	    GpxReader reader = new GpxReader();
	    parser.parse(in, reader);
	    return reader.getTrack();
	} catch (ParserConfigurationException e) {
	    throw new IOException(e.getMessage());
	} catch (SAXException e) {
	    throw new IOException(e.getMessage());
	}
    }

    public static Trackpoint[] readTrack(File file) throws IOException {
	InputStream in = new FileInputStream(file);
	try {
	    return readTrack(in);
	} finally {
	    in.close();
	}
    }

    @Override
    public void startElement(String uri, String localName, String qName,
	    Attributes attributes) throws SAXException {
	buf.setLength(0);
	if (qName.equals("trkpt")) {
	    lat = Double.parseDouble(attributes.getValue("lat"));
	    lon = Double.parseDouble(attributes.getValue("lon"));
	}
    }

    @Override
    public void endElement(String uri, String localName, String qName)
	    throws SAXException {
	if (qName.equals("trkpt")) {
	    track.add(Trackpoint.fromWGS84(lat, lon, ele, time));
	} else if (qName.equals("ele")) {
	    ele = Double.parseDouble(buf.toString());
	} else if (qName.equals("")) {
	    try {
		time = TIME_FORMAT.parse(buf.toString());
	    } catch (ParseException e) {
		throw new SAXException("Invalid time " + buf.toString());
	    }
	}
    }

    @Override
    public void characters(char[] chars, int start, int length)
	    throws SAXException {
	buf.append(chars, start, length);
    }

    private Trackpoint[] getTrack() {
	return track.toArray(new Trackpoint[track.size()]);
    }

}
