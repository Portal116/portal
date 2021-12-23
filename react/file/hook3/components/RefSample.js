import React, { useRef } from 'react';

class RefSample = () => {
    const id = useRef(1);
    const setId = (n) => {
        id.current = n;
    }
    const printId = () => {
        console.log(id);
    }
    return (
        <div>
        refSample
        </div>
    )
}

export default RefSample
