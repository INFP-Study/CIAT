import React, { useState } from 'react';
import { Input, Checkbox, Button, Alert, message, Form } from 'antd';
import styled from 'styled-components';
import {
  EMAIL,
  ESSENTIAL,
  NICK_NAME,
  PASSWORD,
  PASSWORD_CONFIRM,
  SIGN_UP,
  TERMS_OF_USE,
  USER_INFO,
  FULL_CONSENT,
} from '../../constants';
import { theme } from '../../style/theme';

const CheckboxGroup = Checkbox.Group;
const plainOptions = [
  '이용약관동의',
  '개인정보처리방침 동의',
  '개인정보 수집 및 이용 동의',
];

const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
`;

const Title = styled.p`
  font-family: ${theme.fontNotoSans};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightBold};
`;

const Essential = styled.span`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-end;
`;

const EssentialText = styled.span`
  margin-left: 7px;
  font-size: ${theme.fontSizeBody03};
  color: #ff0000;
`;

const Div = styled.div`
  padding-top: 21px;
  width: 100%;
`;

const TopLine = styled.div`
  border-top: 1px solid ${theme.colorLine};
`;

const ButtonAntd = styled(Button)`
  width: 100%;
  height: 50px;
  font-size: ${theme.fontSizeTitle02};
  border-radius: 6px;
  margin-top: 20px;
`;

function SignUp({ handleChange, handleSignUp }) {
  const [checkedList, setCheckedList] = useState('');
  const [checkAll, setCheckAll] = useState(false);

  const onChange = (list) => {
    setCheckedList(list);
    setCheckAll(list.length === plainOptions.length);
  };

  const onCheckAllChange = (e) => {
    setCheckedList(e.target.checked ? plainOptions : []);
    setCheckAll(e.target.checked);
  };

  return (
    <Wrapper>
      <InnerWrapper>
        <Div
          style={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Title>{SIGN_UP}</Title>
        </Div>
        <Div>
          {USER_INFO}
          <TopLine style={{ marginTop: '10px' }} />
          <Essential style={{ fontSize: '12px', paddingTop: '4px' }}>
            *{ESSENTIAL}
          </Essential>
        </Div>
        <Form
          style={{ marginTop: '10px' }}
          layout="vertical"
          onFinish={handleSignUp}
        >
          <Form.Item
            label="이메일"
            name="email"
            rules={[{ required: true, message: '이메일을 입력해주세요.' }]}
          >
            <Input onChange={handleChange} />
          </Form.Item>
          <Form.Item
            label="닉네임"
            name="nickname"
            rules={[{ required: true, message: '닉네임을 입력해주세요.' }]}
          >
            <Input onChange={handleChange} />
          </Form.Item>
          <Form.Item
            label="비밀번호"
            name="password"
            rules={[{ required: true, message: '비밀번호를 입력해주세요.' }]}
          >
            <Input.Password onChange={handleChange} />
          </Form.Item>
          <Form.Item
            label="비밀번호 확인"
            name="passwordConfirm"
            rules={[
              { required: true, message: '비밀번호 확인을 입력해주세요.' },
            ]}
          >
            <Input.Password onChange={handleChange} />
          </Form.Item>
          <Div>
            <Checkbox onChange={onCheckAllChange} checked={checkAll}>
              {FULL_CONSENT}
            </Checkbox>
          </Div>
          <Div>
            <CheckboxGroup
              options={plainOptions}
              value={checkedList}
              onChange={onChange}
            />
          </Div>
          <Form.Item>
            <ButtonAntd
              type="primary"
              htmlType="submit"
              onKeyPress={handleSignUp}
            >
              {SIGN_UP}
            </ButtonAntd>
          </Form.Item>
        </Form>
      </InnerWrapper>
    </Wrapper>
  );
}

export default SignUp;
