package water.api;

import water.*;
import water.api.DownloadDataHandler.DownloadData;
import java.io.InputStream;

public class DownloadDataV1 extends Schema<DownloadData, DownloadDataV1> {

  // Input fields
  @API(help="Key of file to download", required=true) Key key;
  @API(help="Emit double values in a machine readable lossless format with Double.toHexString().") boolean hex_string;

  // Output
  @API(help="CSV Stream", direction=API.Direction.OUTPUT) InputStream csv;
  @API(help="Suggested Filename", direction=API.Direction.OUTPUT) String filename;


  @Override public DownloadData createImpl() {
    DownloadData c = new DownloadData();
    if (key == null) return null;
    c.src_key = key;
    c.hex_string = hex_string;
    return c;
  }

  @Override public DownloadDataV1 fillFromImpl(DownloadData ddata) {
    if (ddata == null) return this;
    key       = ddata.src_key;
    hex_string=ddata.hex_string;
    csv       = ddata.csv;
    filename  = ddata.filename;
    return this;
  }
}
