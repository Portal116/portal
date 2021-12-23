import React, { useEffect, useState } from "react";

const Info = () => {
    const [name, setName] = useState("");
    const [nickName, setNickname] = useState("");

    useEffect(() => {
        console.log("렌더링 완료");
        console.log(name);
        return() => {
            console.log('뒷정리하기');
            console.log(name);
        }
    }, [name]);
        // }) -> 입력할때마다 렌더링
        // },[]) -> 안됨
        // }, [name]) -> name은 입력할때마다 렌더링, 나머진 안됨

    const onChangeName = (e) => {
        setName(e.target.value);
    };

    const onChangeNickName = (e) => {
        setNickname(e.target.value);
    };

    return (
        <div>
            <div>
                이름 입력
                <input type={name} onChange={onChangeName} />
                <p></p>
                닉네임 입력
                <input type={nickName} onChange={onChangeNickName} />
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
