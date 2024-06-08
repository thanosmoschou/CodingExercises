<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ConverterLab2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Exchange Converter</h1> <br />
            <br />
            <asp:Label ID="Label1" runat="server" Text="Enter the origin currency: "></asp:Label>
&nbsp;<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
&nbsp;
            <asp:DropDownList ID="lstCurFrom" runat="server" AutoPostBack="True">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="Enter the destination currency: "></asp:Label>
&nbsp;<asp:DropDownList ID="lstCurTo" runat="server" AutoPostBack="True">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Convert" />
            <br />
            <br />
            <br />
            <asp:Label ID="resLabel" runat="server" Text="Result: "></asp:Label>
        </div>
    </form>
</body>
</html>
