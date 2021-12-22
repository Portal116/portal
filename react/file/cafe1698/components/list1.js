import React, { Component } from "react";

class list1 extends Component {
    state = {
        boards: [
            {
                brdno: 1,
                brdwrite: "a1",
                brdtitle: "게시판 첫줄",
                brddate: new Date(),
            },
            {
                brdno: 2,
                brdwrite: "a2",
                brdtitle: "게시판 둘째줄",
                brddate: new Date(),
            },
        ],
    };
    render() {
        const { boards } = this.state;
        return (
            <div>
                {boards.map(function (row) {
                    return (
                        row.brdno +
                        " " +
                        row.brdwrite +
                        " " +
                        row.brdtitle +
                        " " +
                        row.brddate
                    );
                })}
            </div>
        );
    }
}

export default list1;
