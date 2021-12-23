import React, { useState } from "react";
import Average from "./components/Average";
import Average_useCallback from "./components/Average_useCallback";
import Average_useMemo from "./components/Average_useMemo";
import Average_useRef from "./components/Average_useRef";

const App = () => {
    return (
        <div>
            {/* <Average></Average> */}
            {/* <Average_useMemo></Average_useMemo> */}
            {/* <Average_useCallback></Average_useCallback> */}
            <Average_useRef></Average_useRef>
        </div>
    );
};
export default App;
