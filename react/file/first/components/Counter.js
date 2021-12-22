import React, { Component } from "react";

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            number: 0,
            fixedNumber: 0,
        };
    }
    render() {
        const { number, fixedNumber } = this.state;
        return (
            <div>
                <h1>{number}</h1>
                <h2>바뀌지 않은 값은 {fixedNumber}</h2>
                <button
                    onClick={() => {
                        this.setState({ number: number + 1 });
                        this.setState({fixedNumber:fixedNumber+20})
                    }}
                ></button>
            </div>
        );
    }
}

export default Counter;
