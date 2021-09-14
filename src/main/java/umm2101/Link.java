package umm2101;

// adapted from OpenDSA textbook: http://lti.cs.vt.edu/LTI_ruby/Books/CSCI2101/html/index.html

class Link {
  public Link next; //Point to next node in list
  public Integer data; //Value for this node

  //Constructors
  public Link(Integer dataIn, Link nextIn) {
    this.data = dataIn;
    this.next = nextIn;
  }

  public Link(Link nextIn) {
    this.data = null;
    this.next = nextIn;
  }

  Integer getElement() { // Return the data field
    return data;
  }

  void setElement(Integer newData) { // Set the data field
    data = newData;
  }

  Link getNext() { // Return the next field
    return next;
  }

  void setNext(Link newNext) { // Set the next field
    next = newNext;
  }
}