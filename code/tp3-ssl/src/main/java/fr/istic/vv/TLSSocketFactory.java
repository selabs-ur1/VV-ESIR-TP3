package fr.istic.vv;

import java.util.ArrayList;
import java.util.List;

public class TLSSocketFactory {

  public void prepareSocket(SSLSocket socket) {

    String[] supported = socket.getSupportedProtocols();
    String[] enabled = socket.getEnabledProtocols();

    List<String> target = new ArrayList<String>();
    if (supported != null) {
      // Append the preferred protocols in descending order of preference
      // but only do so if the protocols are supported
      TLSProtocol[] values = TLSProtocol.values();
      for (int i = 0; i < values.length; i++) {
        final String pname = values[i].getProtocolName();
        if (existsIn(pname, supported)) {
          target.add(pname);
        }
      }
    }

    if (enabled != null) {
      // Append the rest of the already enabled protocols to the end
      // if not already included in the list
      for (String pname : enabled) {
        if (!target.contains(pname)) {
          target.add(pname);
        }
      }
    }

    if (target.size() > 0) {
      String[] enabling = target.toArray(new String[target.size()]);
      socket.setEnabledProtocols(enabling);
    }

  }

  /**
   * Returns true if the given element exists in the given array; false otherwise.
   */
  private boolean existsIn(String element, String[] a) {
    for (String s : a) {
      if (element.equals(s)) {
        return true;
      }
    }
    return false;
  }

}
