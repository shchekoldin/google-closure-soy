package net.intellij.plugins.soy.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import net.intellij.plugins.soy.SoyElementTypes;

%%

%class _SoyLexer
%implements FlexLexer
%final
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]

Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

Variable = "$" [\._a-zA-Z]*
String = [\"\'] [^\"\']* [\"\']

%x STATE_IN_SCRIPTING
%x STATE_IN_JAVA_DOC
%x LOOKING_FOR_JAVA_DOC_PARAM
%x LOOKING_FOR_NAMESPACE_NAME
%x LOOKING_FOR_TEMPLATE_NAME

%%

<YYINITIAL> {

    "/**"                     { yybegin(STATE_IN_JAVA_DOC); return SoyElementTypes.COMMENT; }
    "{"                       { yybegin(STATE_IN_SCRIPTING); return SoyElementTypes.START_SCRIPT; }

}

<STATE_IN_JAVA_DOC> {
    
    "*/"                      { yybegin(YYINITIAL); return SoyElementTypes.COMMENT; }
    "@param" [ ]+             { yybegin(LOOKING_FOR_JAVA_DOC_PARAM); return SoyElementTypes.COMMENT; }
    (.|\n)                    { return SoyElementTypes.COMMENT; }

}

<LOOKING_FOR_JAVA_DOC_PARAM> [^ ]+ {
    yybegin(STATE_IN_JAVA_DOC);
    return SoyElementTypes.JAVA_DOC_PARAM;
}

<STATE_IN_SCRIPTING> {

    "}"                       { yybegin(YYINITIAL); return SoyElementTypes.END_SCRIPT; }

    // Keywords

    "namespace"               { yybegin(LOOKING_FOR_NAMESPACE_NAME); return SoyElementTypes.KEYWORD; }
    "template"                { yybegin(LOOKING_FOR_TEMPLATE_NAME); return SoyElementTypes.KEYWORD; }
    "literal"                 { return SoyElementTypes.KEYWORD; }
    "print"                   { return SoyElementTypes.KEYWORD; }
    "msg"                     { return SoyElementTypes.KEYWORD; }
    "not"                     { return SoyElementTypes.KEYWORD; }
    "if"                      { return SoyElementTypes.KEYWORD; }
    "elseif"                  { return SoyElementTypes.KEYWORD; }
    "else"                    { return SoyElementTypes.KEYWORD; }
    "if"                      { return SoyElementTypes.KEYWORD; }
    "switch"                  { return SoyElementTypes.KEYWORD; }
    "case"                    { return SoyElementTypes.KEYWORD; }
    "default"                 { return SoyElementTypes.KEYWORD; }
    "foreach"                 { return SoyElementTypes.KEYWORD; }
    "ifempty"                 { return SoyElementTypes.KEYWORD; }
    "for"                     { return SoyElementTypes.KEYWORD; }
    "call"                    { return SoyElementTypes.KEYWORD; }
    "param"                   { return SoyElementTypes.KEYWORD; }
    "css"                     { return SoyElementTypes.KEYWORD; }

    // Other

    {Comment}                 { return SoyElementTypes.COMMENT; }
    {Variable}                { return SoyElementTypes.VARIABLE; }

}

<LOOKING_FOR_NAMESPACE_NAME> {
    [^ \}]+                   { return SoyElementTypes.NAMESPACE_NAME; }
    [ ]                       { return SoyElementTypes.BAD_CHARACTER; }
    "}"                       { yybegin(YYINITIAL); }
}

<LOOKING_FOR_TEMPLATE_NAME> {
    [^ \}]+                   { return SoyElementTypes.TEMPLATE_NAME; }
    [ ]                       { return SoyElementTypes.BAD_CHARACTER; }
    "}"                       { yybegin(YYINITIAL); }
}

<YYINITIAL, STATE_IN_SCRIPTING> {

    {WhiteSpace}              { return SoyElementTypes.WHITE_SPACE; }
    {String}                  { return SoyElementTypes.STRING; }
    (.|\n)                    { return SoyElementTypes.BAD_CHARACTER; }

}
