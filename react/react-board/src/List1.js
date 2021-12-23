import React, { Component } from "react";
/*
 simple list
 */
class List1 extends Component {
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
    const list = boards.map(function (row) {
      return row.brdno + row.brdwriter + row.brddate;
    });

    return <div>{list}</div>;
  }
}

export default List1;
