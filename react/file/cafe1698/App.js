import {Route, Routes, BrowserRouter as Router} from 'react-router-dom'
import "./App.css";

import board from "./components/board";
import list1 from "./components/list1";
import list2 from "./components/list2";
import list3 from "./components/list3";
import updateDelete from "./components/updateDelete";
import write from "./components/write";

function App() {
    return (
        <Router>
            <Routes>
                <Route exact path="./components/list1" component={list1}></Route>
                <Route exact path="./components/list2" component={list2}></Route>
                <Route exact path="./components/list3" component={list3}></Route>
                <Route exact path="/components/board" component={board}></Route>
                <Route exact path="./components/write" component={write}></Route>
                <Route exact path="./components/updateDelete" component={updateDelete}></Route>
            </Routes>
        </Router>
    );
}

export default App;