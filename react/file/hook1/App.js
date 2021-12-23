import React, { useState } from "react";
import Info from "./components/Info";
import Counter from "./components/Counter";

const App = () => {
    const [visible, setVisible] = useState(false);
    return (
        <div>
            {/* <button
                onClick={() => {
                    setVisible(!visible);
                }}
            >
                {visible ? "숨기기" : "보이기"}
            </button>
            <hr></hr>
            {visible && <Info></Info>} */}
            <Counter></Counter>
        </div>
    );
};
export default App;
