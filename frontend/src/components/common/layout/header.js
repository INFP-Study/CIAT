import React, { useEffect, useState } from 'react';
import { Affix, Button, Layout, notification } from 'antd';
import { SIGN_IN, SIGN_OUT, SIGN_OUT_SUCCESS, TITLE } from '../../../constants';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { MAIN_URL, SIGN_IN_URL } from '../../../constants/urls';
import { MdAccountCircle } from 'react-icons/md';
import { theme } from '../../../style/theme';
import { useSelector } from 'react-redux';

const { Header } = Layout;

const HeaderStyle = {
  //Header 태그 참조 이슈가 있어 스타일 방법 변경
  display: 'flex',
  justifyContent: 'space-between',
  height: '70px',
  padding: '10px 40px',
  alignItems: 'center',
  backgroundColor: `${theme.colorWhite}`,
  borderBottom: `${theme.borderLine}`,
};

const Logo = styled(Link)`
  font-family: ${theme.fontLogo};
  font-size: ${theme.fontSizeLogo};
  color: ${theme.colorPrimary};
  :hover {
    color: ${theme.colorPrimary};
  }
`;

const UserInfo = styled(Link)`
  display: flex;
  align-items: center;
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  color: ${theme.colorText};
  :hover {
    color: ${theme.colorText};
  }
`;

function SiteHeader() {
  const signOut = () => {
    notification.success({
      message: 'CIAT',
      description: SIGN_OUT_SUCCESS,
    });
    localStorage.removeItem('token');
  };

  return (
    <Affix offsetTop={0}>
      <Header style={HeaderStyle}>
        <Logo to={MAIN_URL}>{TITLE}</Logo>
        {localStorage.getItem('token') === null ? (
          <UserInfo to={SIGN_IN_URL}>
            <MdAccountCircle
              style={{ fontSize: theme.fontSizeIcon, margin: '0px 10px' }}
            />
            {SIGN_IN}
          </UserInfo>
        ) : (
          <UserInfo to={MAIN_URL} onClick={signOut}>
            <MdAccountCircle
              style={{ fontSize: theme.fontSizeIcon, margin: '0px 10px' }}
            />
            {SIGN_OUT}
          </UserInfo>
        )}
      </Header>
    </Affix>
  );
}

export default SiteHeader;
