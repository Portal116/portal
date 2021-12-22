import React from "react";

const MyComponent = (props) => {
    return <div>리액트 처음 배움{props.name}</div>;
};

MyComponent.defaultProps = {
    name: "홍길동",
};
export default MyComponent;
