import React, { useState } from "react";
import Info from "./components/Info";
import Counter from "./components/Counter";

const App = () => {
    const [visible, setVisible] = useState(false);
    return (
        <div>
            
            <Info></Info>
            {/* <Counter></Counter> */}
        </div>
    );
};
export default App;
