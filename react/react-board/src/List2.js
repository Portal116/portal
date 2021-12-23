import React, { Component } from "react";
/*
 simple list
 */
class List2 extends Component {
  state = {
    boards: [
      {
        brdno: 1,
        brdwriter: "hyun",
        brdtitle: "title1",
        brddate: new Date(),
      },
      {
        brdno: 2,
        brdwriter: "hee",
        brdtitle: "title2",
        brddate: new Date(),
      },
    ],
  };

  render() {
    const { boards } = this.state;

    return (
      <div>
        {boards.map(function (row) {
          return row.brdno + row.brdwriter;
        })}
      </div>
    );
  }
}

export default List2;
