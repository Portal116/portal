import React, { useEffect, useReducer } from "react";

function reducer(state, action) {
    return {
        ...state,
        [action.name]: action.value,
    };
}
const Info = () => {
    const [state, dispatch] = useReducer(reducer, {
        name: "",
        nickName: "",
    });

    const {name, nickName} = state;

    const onChangeName = (e) => {
        dispatch(e.target);
    };

    return (
        <div>
            <div>
                이름 입력
                <input name="name" value={name} onChange={onChangeName} />
                <p></p>
                닉네임 입력
                <input name="nickName" value={nickName} onChange={onChangeName} />
            </div>
            <div>
                <div>
                    <b> 이름 : </b> {name}
                </div>
                <div>
                    <b> 닉네임 : </b> {nickName}
                </div>
            </div>
        </div>
    );
};

export default Info;
