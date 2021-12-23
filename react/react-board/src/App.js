import React, { Component } from "react";
import { Route, BrowserRouter as Router } from "react-router-dom";

import List1 from "./List1";
import List2 from "./List2";
import List3 from "./List3";
import Write4 from "./Write4";
import UD5 from "./UD5";
import Board6 from "./Board6";

// simple list
class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Route exact path="/" component={List1} />
          <Route exact path="/List1" component={List1} />
          <Route exact path="/List2" component={List2} />
          <Route exact path="/List3" component={List3} />
          <Route exact path="/Write4" component={Write4} />
          <Route exact path="/UD5" component={UD5} />
          <Route exact path="/Board6" component={Board6} />
        </div>
      </Router>
    );
  }
}

export default App;
