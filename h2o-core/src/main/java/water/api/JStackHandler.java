package water.api;

import water.H2O;
import water.util.JStack;

public class JStackHandler extends Handler<JStack,JStackV2> {
  @Override protected int min_ver() { return 1; }
  @Override protected int max_ver() { return Integer.MAX_VALUE; }

  //No Input

  //Output
  JStack _jstack; // for each node in the cloud it contains all threads stack traces

  @SuppressWarnings("unused") // called through reflection by RequestServer
  public JStackV2 fetch(int version, JStack js) {
    _jstack = new JStack();
    _jstack.execImpl();
    return schema(version).fillFromImpl(_jstack);
  }

  @Override protected JStackV2 schema(int version) { return new JStackV2(); }
  @Override public void compute2() { throw H2O.unimpl(); }

}
